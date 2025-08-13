; файл test_03_02.asm
; примерни данни за тестване:
; -4 -33 -22 -11 0 1 2 3 4 550

%include "io64.inc"
    LQ equ 10
section .data
section .bss
    nums resq LQ
section .text
global main

proc:
    pushfq
        add r9, LQ
        xor r9, 2
        add r9, r10
        add [nums + rdx*8], r9
        dec r10
    popfq
ret ; proc

main:

    mov rdx, -1
    mov r10, 3
  .step:
    inc rdx
    cmp rdx, LQ
    je .next
        GET_DEC 8, r9
        call proc
    jmp .step
  .next:

    xor r8, r8
    mov rcx, LQ
  next:
        mov r10, [nums + rcx*8 - 8]
        cmp r10, 0
        jnge step
            shr r10, 2
            jmp result
      step:
        add r10, LQ
      result:
        add r8, r10
    loop next
    PRINT_DEC 8, r8
    NEWLINE

xor rax, rax
ret ; main
