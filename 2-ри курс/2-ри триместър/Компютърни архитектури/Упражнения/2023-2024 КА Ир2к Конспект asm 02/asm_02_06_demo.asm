;Няма четене от стандартния входен поток.

;В стандартния изходен поток (в прозореца Output) извежда:
;6 -5 4 -3 2 -1 
;6 -5 4 -3 2 -1 
;-1 , 2 , -3 , 4 , -5 , 6
;-1 , 2 , -3 , 4 , -5 , 6

%include "io64.inc"
section .data
    nums    dq -1, 2, -3, 4, -5, 6
  Len equ ($ - nums) / 8 ; Len е точно броя
                         ; на числата от горния ред
section .bss
    copy resq Len ; заделя памет за Len 8-байтови данни
section .text
global main
main:

        mov rcx, Len ; rcx е номер на копирано число
                     ; при номерация, започваща от 1
    step0:      mov rax, [nums + rcx*8 - 8]
                mov [copy + rcx*8 - 8], rax
            loop step0
    
        mov r15, Len ; r15 е номер на копирано число
                     ; при номерация, започваща от 1
    step1:      PRINT_DEC 8, [copy + r15*8 - 8]
                PRINT_CHAR ' '
            dec r15 ; r15 става номер на предишно число
            jnz step1 ; преход при номер, различен от 0
    NEWLINE
    
        lea rsi, [copy + 8 * (Len - 1)]
            ; rsi е адрес на извеждано число
    step2:      PRINT_DEC 8, [rsi]
                PRINT_CHAR ' '
            sub rsi, 8 ; rsi става адрес на предишно число
            cmp rsi, copy ; от адреса rsi изважда адреса copy
            jge step2 ; преход при rsi>=copy
    NEWLINE
    
        xor r9, r9 ; r9 е индекс на извеждано число
                   ; при индексация, започваща от 0
        lea rax, [empty]
            ; rax е адрес на низ,
            ; предшестващ извежданото число
    step3:      PRINT_STRING [rax]
                lea rax, [s]
                PRINT_DEC 8, [copy + r9*8]
            inc r9 ; r9 става индекс на следващо число
            cmp r9, Len ; от индекса r9 изважда броя Len
            jne step3 ; преход при r9!=Len
    NEWLINE
    
        lea r15, [copy] ; r15 е адрес на извеждано число
        ;mov r15, copy
        lea rax, [empty]
            ; rax е адрес на низ,
            ; предшестващ извежданото число
    step4:      PRINT_STRING [rax]
                lea rax, [s]
                PRINT_DEC 8, [r15]
            add r15, 8 ; r15 става адрес на следващо число
            cmp r15, copy + 8 * Len
                ; от адреса r15 на извеждания елемент
                ; изважда адреса на байта, разположен
                ; точно след последното число
            jne step4 ; преход при r15 != copy+8*Len
    NEWLINE
  
xor rax, rax
ret

section .data
    s       db " , "
    empty   db 0
    
    
    
    