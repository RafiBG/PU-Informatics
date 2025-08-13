;1 2 3 4 5 6 7 8 9 10
;-1 -2 -3 -4 -5 -6 -7 -8 -9
%include "io64.inc"
x equ 7
section .data
N dw x dup (-11, -22), -256
section .bss
section .text
global main
f:
mov rcx, 15
.L1: mov dword [N+rcx*2-2],0
loop .L1
.L2: mov dx, cx
GET_DEC 2, cx
cmp cx, dx
je .L4
lea rsi, [N+7*2]
call t
shl ah, 1
xor rdx, rdx
mov dl, ah
bt rax, 0
jc .L3
add rsi, rdx
jmp .L5
.L3: sub rsi, rdx
.L5: inc word [rsi]
jmp .L2
.L4: ret
main:
mov rcx, 15
.L1: PRINT_DEC 2, [N+rcx*2-2]
PRINT_CHAR ' '
dec rcx
jnz .L1
NEWLINE
call f
xor rcx, rcx
.L2: PRINT_DEC 2, [N+rcx*2]
PRINT_CHAR ' '
inc rcx
cmp rcx, 15
jl .L2
NEWLINE
xor eax, eax
ret
t:  pushfq
mov ax, cx
bt cx, 15
jnc .L1
neg ax
.L1: and ax, 7
shl ax, 8
bt cx, 15
setc al
popfq
ret



