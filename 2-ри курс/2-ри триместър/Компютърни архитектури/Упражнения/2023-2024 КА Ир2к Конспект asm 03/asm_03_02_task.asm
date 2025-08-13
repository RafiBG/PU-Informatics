;Прозорецът Input може да бъде празен.

;Извеждан текст в прозореца Output:
;sequence: 1 , -1 , 55 , -5 , 3 , -3 , 2 , -2 , 4 , -4
;maximum: 55

%include "io64.inc"

section .data
    numbers     dq -4, 4, -2, 2, -3, 3, -5, 55, -1, 1
  Len equ ($ - numbers) / 8 ; Len е точно броя на числата
  ; важно е $ да се използва преди следващата инструкция
    message1    db "sequence: ", 0
    message2    db "maximum: ", 0
    
section .bss

section .text

global main

printNumbers:
    ; извежда числа от 8-байтови ДК
    ; по ред на намаляване на адресите
    ;   rcx --- брой на числата
    ;   rsi --- адрес на 1-то число
    pushfq
        cmp rcx, 1
        jl .stop ; преход при rcx < 1
            push rcx
            push r9 ; r9 --- адрес на разделител преди число
                    lea r9, [.empty] ; за празен низ
                .next:  PRINT_STRING [r9] ; извежда разделител
                        lea r9, [.separator] ; за истински разделител
                        PRINT_DEC 8, [rsi + rcx*8 - 8] ; извежда число
                    dec rcx ; получава номер (от 1) на предходно число
                    jnz .next ; преход при rcx != 0
            pop r9
            pop rcx
        .stop:
        NEWLINE
    popfq
section .data
    .separator  db " , "
    .empty      db 0
section .text
ret ; printNumbers

main:
    
    PRINT_STRING [message1]
    mov rcx, Len
    lea rsi, [numbers]
    call printNumbers
    call max
    PRINT_STRING [message2]
    PRINT_DEC 8, rax
    NEWLINE
    
xor eax, eax
ret ; main

max:    ; намира максимума за числата от редица от 8-байтови ДК;
        ; когато няма числа, връща минималното число с 8-байтов ДК
        ;   rcx --- брой на числата; удобно е за цикъл с loop
        ;   rsi --- адрес на 1-то число
        ;   rax --- намерен максимум
    pushfq
        mov rax, 1 ; записва в rax числото 1
        ror rax, 1 ; получава в rax 1, последвана от 63 нули;
                   ; това е 64-разрядния ДК на минималното число,
                   ; което може да се кодира в 64 разряда в ДК
        cmp rcx, 1
        jl .stop ; преход при rcx < 1
            push rcx
                .next:  cmp rax, [rsi + rcx*8 - 8]
                        jge .step ; преход при rax>=[rsi+rcx*8-8]
                            mov rax, [rsi + rcx*8 - 8]
                        .step:
                    loop .next
            pop rcx
        .stop:
    popfq
ret ; max
