;Примерно съдържание на прозореца Input:
;1 2 3 4 -5 -6 -7 -8 0 0 11

;Съответен извеждан текст в прозореца Output:
;11 ; 0 ; 0 ; -8 ; -7 ; -6 ; -5 ; 4 ; 3 ; 2 ; 1
;count of positives numbers: 5

%include "io64.inc"
  Len equ 11 ; брой на прочитаните числа (трябва Len>0)
section .data
    message1    db "numbers: ", 0
    message2    db "count of positives numbers: ", 0
    separator   db " ; "
    emptyString db 0
section .bss
    nums        resq Len ; памет за Len 8-байтови данни
section .text
global main
main:

    ; а) въвеждане
        mov rdi, Len ; rdi е номер на число
                     ; при номерация, започваща от 1
    next:      GET_DEC 8, [nums + rdi*8 - 8]
            dec rdi ; предходен номер на число
            jnz next ; преход при rdi != 0
            
    ; б) извеждане в ред, обратен на този при прочитането
        xor rsi, rsi ; rsi е индекс на число
                     ; при индексация, започваща от 0
        lea r9, [emptyString] ; r9 е адрес на низ,
                              ; предшестващ извеждано число
    nextNumber:
                PRINT_STRING [r9]
                lea r9, [separator]
                PRINT_DEC 8, [nums + rsi*8]
            inc rsi
            cmp rsi, Len
            jnge nextNumber ; преход при rsi < Len
            
    ; в)
    ; преброяване на строго положителните
    xor rax, rax ; rax е точно броя на намерените положителни
        mov rcx, Len ; rcx е номер на число
                     ; при номерация, започваща от 1
    count:      cmp dword [nums + rcx*8 - 8], 0
                jng step
                    inc rax
            step: loop count
    NEWLINE
    ; извеждане на броя на положителните числа
    PRINT_STRING [message2]
    PRINT_DEC 8, rax
    NEWLINE
  
xor rax, rax
ret
