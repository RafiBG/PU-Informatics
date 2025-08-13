; файл test_03_01.asm
; примерни данни за тестване:
; -10 10 -19 19 -5 5 -15 15 -2347 3353

%include "io64.inc"
    L equ 10
section .data
section .bss
    N resd L
section .text
global main

conv:
    pushfq
        cmp eax, 0
        jge .step
            neg eax
      .step:
        and eax, 15
    popfq
ret ; conv

main:

    xor ecx, ecx
  next:
    cmp ecx, L
    je step
        GET_DEC 4, eax
        call conv
        mov [N + ecx*4], eax
    inc ecx
    jmp next
  step:
  
    xor eax, eax
    mov rcx, L
    mov esi, [N + (L - 1) * 4]
  plus:
        cmp [N + rcx*4 - 4], esi
        jg toLoop
            inc eax
      toLoop:
    loop plus
    PRINT_DEC 4, eax
    NEWLINE

xor rax, rax
ret ; main
