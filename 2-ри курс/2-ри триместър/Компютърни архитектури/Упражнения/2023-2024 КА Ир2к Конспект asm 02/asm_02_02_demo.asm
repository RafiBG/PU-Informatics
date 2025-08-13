;При празен прозорец Input:

;Съответен извеждан текст в прозореца Output:
;0
;0
;""
;0
;0
;""

%include "io64.inc"
section .data
section .bss
    s   resb 10
section .text
global main
main:

    GET_DEC 8, rax
    PRINT_DEC 8, rax
    NEWLINE
    GET_HEX 8, rax
    PRINT_DEC 8, rax
    NEWLINE
    GET_STRING [s], 10
    PRINT_CHAR '"'
    PRINT_STRING [s]
    PRINT_CHAR '"'
    NEWLINE
    

    GET_DEC 8, rax
    PRINT_DEC 8, rax
    NEWLINE
    GET_HEX 8, rax
    PRINT_DEC 8, rax
    NEWLINE
    GET_STRING [s], 10
    PRINT_CHAR '"'
    PRINT_STRING [s]
    PRINT_CHAR '"'
    NEWLINE
    
xor eax, eax
ret