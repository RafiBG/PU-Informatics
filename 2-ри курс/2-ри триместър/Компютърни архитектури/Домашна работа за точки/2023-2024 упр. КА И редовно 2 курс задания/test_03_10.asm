; файл test_03_10.asm
; примерни данни за тестване:
; 47 61 -47 -61 105 204 -105 -204 123 -123

%include "io64.inc"
    L10 equ 10
section .data
section .bss
    LNums resq L10
section .text
global main

procNum:
    pushfq
    push rdi
        mov [LNums + rax*8], rdi
        and rdi, r10
        xor rdi, r14
        add [LNums + rax*8], rdi
    pop rdi
    popfq
ret ; procNum

main:

    xor rax, rax
    mov r14, 0b10101
    mov r10, 0b11111
  .step:
    cmp rax, L10
    je .next
        GET_DEC 8, rdi
        call procNum
    inc rax
    jmp .step
  .next:
  
    mov rax, 100
    mov rcx, L10
  next:
        mov r10, [LNums + rcx*8 - 8]
        and r10, r14
        jnz step
            inc r10
      step:
        sub rax, r10
        add rax, [LNums + rcx*8 - 8]
    loop next
    PRINT_DEC 8, rax
    NEWLINE

xor rax, rax
ret ; main
