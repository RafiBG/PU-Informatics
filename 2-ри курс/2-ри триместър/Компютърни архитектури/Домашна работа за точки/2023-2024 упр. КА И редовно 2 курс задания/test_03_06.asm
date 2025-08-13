; файл test_03_06.asm
; примерни данни за тестване:
; -2 2 -9 9 -15 15 -21 21 -2887 1

%include "io64.inc"
    L equ 10
section .data
section .bss
    N resq L
section .text
global main

adRax:
    pushfq
        cmp r9, 0
        jge .step
            neg r9
      .step:
        and r9, 15
        add rax, r9
    popfq
ret ; adRax

main:

    xor rax, rax
    xor esi, esi
  next:
    cmp esi, L
    je step
        GET_DEC 8, r9
        call adRax
        mov [N + esi*8], rax
    inc esi
    jmp next
  step:
  
    xor eax, eax
    mov rcx, L
    mov rsi, [N + (L - 1) * 8]
    and rsi, 7
  plus:
        mov r15, [N + rcx*8 - 8]
        and r15, 7
        xor r15, rsi
        jz toLoop
            inc eax
      toLoop:
    loop plus
    PRINT_DEC 4, eax
    NEWLINE

xor rax, rax
ret ; main
