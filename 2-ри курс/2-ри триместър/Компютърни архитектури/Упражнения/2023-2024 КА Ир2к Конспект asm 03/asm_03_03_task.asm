;Примерно съдържание на прозореца Input:
;1 2 3 4 5 6
;-1 -2 -3 -4 -5

;Съответен текст извеждан в прозореца Output:
;2 , 4 , 6 , -2 , -4 , -5 , -3 , -1 , 5 , 3 , 1

%include "io64.inc"
  Len equ 11 ; брой на числата в редицата
section .data    
section .bss
    numbers resq Len ; място за записване на Len данни по 8 байта
section .text
global main

read:   ; Въвежда цели числа и ги записва в 8-байтови ДК.
        ; Четните числа записва от най-малкия адрес 
        ; в ред по нарастване на адресите.
        ; Нечетните числа записва от най-големия адрес
        ; в ред по намаляване на адресите
        ;   rdx --- брой на числата
        ;   r9 --- най-малък адрес за записване
    pushfq
        cmp rdx, 1
        jl .end ; преход при брой по-малък от едно
            push r9 ; r9 --- адрес за поредното четно число
            push r10 ; r10 --- адрес за поредното нечетно число
            push rax
                    lea r10, [r9 + rdx*8 - 8]
                    ; сега r10 е последен адрес за число
                .nextNumber:
                    GET_DEC 8, rax ; rax --- поредно прочетено число
                    test rax, 1
                    jnz .oddNumber ; преход при нечетно число
                        ; числото е четно
                        mov [r9], rax
                        add r9, 8
                        jmp .nextStep
                    .oddNumber:
                        mov [r10], rax
                        sub r10, 8
                    .nextStep:
                    cmp r9, r10
                    jle .nextNumber
            pop rax
            pop r10
            pop r9
        .end:
    popfq
ret ; read

write:  ; Извежда в 10-ичен запис числа, четени от 8-байтови ДК
        ; по ред на нарастване на адресите.
        ;   rdx --- брой на числата
        ;   r9 --- най-малък адрес на число
    pushfq
    push rax
    push r15
            xor rax, rax ; rax --- индекс на число за извеждане
            lea r15, [.emptyString] ; r15 --- адрес на разделител преди число
        .nextNumber:
                cmp rax, rdx
                jge .noNumbers ; преход при индекс по-голям или равен на броя
                    PRINT_STRING [r15]
                    lea r15, [.delimiter]
                    PRINT_DEC 8, [r9 + rax*8]
                inc rax
                jmp .nextNumber
            
        .noNumbers:
        NEWLINE    
    pop r15
    pop rax
    popfq
  section .data
    .delimiter      db " , "
    .emptyString    db 0
  section .text
ret ; write

main:

    mov rdx, Len
    lea r9, [numbers]
    call read
    call write

xor rax, rax
ret ; main