; файл test_03_03.asm
; примерни данни за тестване:
; 100 200 32 -1 -2 -3 150 250 -147 -250

%include "io64.inc"
    Lng equ 10
section .data
section .bss
    Nums resq Lng
section .text
global main

procNext:
    pushfq
    push r11
        mov [Nums + rsi*8], r11
        and r11, 3
        add rax, r11
        add [Nums + rsi*8], rax
    pop r11
    popfq
ret ; procNext

main:

    mov rax, -50
    xor rsi, rsi
  next1:
    cmp rsi, Lng
    je step1
        GET_DEC 8, r11
        call procNext
    inc rsi
    jmp next1
  step1:
  
    xor r9, r9
    mov rcx, Lng
    mov rsi, 19
  next2:
        mov rax, [Nums + rcx*8 - 8]
        xor rax, rsi
        jz toLoop
            sub r9, [Nums + rcx*8 - 8]
      toLoop:
    loop next2
    PRINT_DEC 8, r9
    NEWLINE

xor rax, rax
ret ; main
