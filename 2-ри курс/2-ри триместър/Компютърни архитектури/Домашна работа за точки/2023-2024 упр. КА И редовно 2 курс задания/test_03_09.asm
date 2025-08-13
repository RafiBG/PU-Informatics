; файл test_03_09.asm
; примерни данни за тестване:
; -9 -5 -4 11 3 51 9 6 20 11 32 40

%include "io64.inc"
    LN equ 11
section .data
section .bss
    numQ resq LN
section .text
global main

procN:
    pushfq
        mov [numQ + r10*8], r15
        and r15, 1
        adc rax, r15
        and rax, r8
        add [numQ + r10*8], rax
    popfq
ret ; procN

main:

    xor r10, r10
    mov r8, 0b1111
    mov rax, 0b110
  .step:
    cmp r10, LN
    je .next
        GET_DEC 8, r15
        call procN
    inc r10
    jmp .step
  .next:
  
    mov r15, -1
    mov rcx, LN
  next:
        mov r9, [numQ + rcx*8 - 8]
        cmp r9, 0
        jnge step
            sal r9, 1
            jmp result
      step:
        or r9, 4
      result:
        add r15, r9
    loop next
    PRINT_DEC 8, r15
    NEWLINE

xor r10, r10
ret ; main
