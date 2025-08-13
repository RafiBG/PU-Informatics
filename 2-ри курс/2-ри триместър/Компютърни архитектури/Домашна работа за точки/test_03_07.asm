; файл test_03_07.asm
; примерни данни за тестване:
; 11 23 33 45 5 -44 -30 -22 -11

%include "io64.inc"
    LLL equ 9
section .data
section .bss
    NNs resq LLL
section .text
global main

procElm:
    pushfq
        xor rsi, rax
        add rsi, r11
        neg rsi
        mov [NNs + r9*8], rsi
        dec r11
    popfq
ret ; procElm

main:

    mov r9, -1
    mov rax, -0b1011
    xor r11, r11
  .next:
    inc r9
    cmp r9, LLL
    je .stop
        GET_DEC 8, rsi
        call procElm
    jmp .next
  .stop:
  
    xor r10, r10
    mov rcx, LLL
  next:
        mov rdi, rcx
        add rdi, qword [NNs + rcx*8 - 8]
        jnge step
            sal rdi, 1
            jmp result
      step:
        neg rdi
      result:
        add r10, rdi
    loop next
    PRINT_DEC 8, r10
    NEWLINE

xor r10, r10
ret ; main
