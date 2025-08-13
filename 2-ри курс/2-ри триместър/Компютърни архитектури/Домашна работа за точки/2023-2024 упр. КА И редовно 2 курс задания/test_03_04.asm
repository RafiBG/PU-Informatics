; файл test_03_04.asm
; примерни данни за тестване:
; 14 20 -3 -40 55 66 -123 -60 -23

%include "io64.inc"
    LarN equ 9
section .data
section .bss
    arN resq LarN
section .text
global main

procElm:
    pushfq
        xor r9, 7
        xor r9, r11
        dec r9
        mov [arN + r15*8], r9
        xor r11, -1
    popfq
ret ; procElm

main:

    mov r15, -1
    mov r11, 0b11
  .next:
    inc r15
    cmp r15, LarN
    je .stop
        GET_DEC 8, r9
        call procElm
    jmp .next
  .stop:
  
    mov rax, 3
    mov rcx, LarN
  next:
        cmp qword [arN + rcx*8 - 8], 0
        jnge step
            mov r8, 4
            jmp result
      step:
        mov r8, [arN + rcx*8 - 8]
        and r8, 15
      result:
        add rax, r8
    loop next
    PRINT_DEC 8, rax
    NEWLINE

xor r10, r10
ret ; main
