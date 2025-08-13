; файл test_03_08.asm
; примерни данни за тестване:
; 22 33 44 -22 -33 -44 123 -123 -21 258

%include "io64.inc"
    Lt equ 10
section .data
section .bss
    Ns resq Lt
section .text
global main

procNum:
    pushfq
    push rcx
        sub rcx, r11
        mov [Ns + r8*8], rcx
        and rcx, 0x1f
        sub r11, rcx
    pop rcx
    popfq
ret ; procNum

main:

    mov r11, 0xff
    xor r8, r8
  step1:
    cmp r8, Lt
    je next1
        GET_DEC 8, rcx
        call procNum
    inc r8
    jmp step1
  next1:
  
    mov r11, 0xff
    mov r15, r11
    mov rcx, Lt
  step2:
        mov rdi, [Ns + rcx*8 - 8]
        and rdi, r11
        cmp rdi, 0xf
        jng toLoop
            sub r15, [Ns + rcx*8 - 8]
      toLoop:
    loop step2
    PRINT_DEC 8, r15
    NEWLINE

xor rax, rax
ret ; main
