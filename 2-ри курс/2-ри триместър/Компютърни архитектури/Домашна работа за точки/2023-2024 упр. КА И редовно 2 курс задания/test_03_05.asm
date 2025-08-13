; файл test_03_05.asm
; примерни данни за тестване:
; 1000 -900 800 3 -100 -400 -666 -7 -77

%include "io64.inc"
    Lhh equ 9
section .data
section .bss
    nnQ resq Lhh
section .text
global main

procNext:
    pushfq
        and rax, 255
        mov [nnQ + rdx*8], rax
        xor [nnQ + rdx*8], r8
        inc qword [nnQ + r10*8]
        xor r8, -1
    popfq
ret ; procNext

main:

    mov rdx, -1
    mov r8, 0b101
  .next:
    inc rdx
    cmp rdx, Lhh
    je .stop
        GET_DEC 8, rax
        call procNext
    jmp .next
  .stop:
  
    mov rax, 3
    mov rcx, Lhh
  next:
        cmp qword [nnQ + rcx*8 - 8], 0
        jnge step
            mov r8, 4
            jmp result
      step:
        mov r8, [nnQ + rcx*8 - 8]
        and r8, 15
      result:
        add rax, r8
    loop next
    PRINT_DEC 8, rax
    NEWLINE

xor r10, r10
ret ; main
