; Извежда равни стойности за y и z
; и те са с единица по-големи от стойността на x.
; Следователно няма заделена памет за y.

%include "io64.inc"
section .data
    x db '8' ; записва в паметта кода на цифрата '8'
    y equ $ ; y е число, равно на адреса на байта
            ; точно след последното записано в паметта
    z equ $ ; z е число, равно на адреса на байта
            ; точно след последното записано в паметта
section .bss
section .text
global main
main:

    PRINT_CHAR 'x'
    PRINT_CHAR '='
    mov r9, x ; интерпретира x като число
              ; и го записва в регистъра r9
    PRINT_DEC 8, r9
    NEWLINE
    
    PRINT_CHAR 'y'
    PRINT_CHAR '='
    mov r9, y ; записва числото y в регистъра r9
    PRINT_DEC 8, r9
    NEWLINE
    
    PRINT_CHAR 'z'
    PRINT_CHAR '='
    lea r9, [z] ; интерпретира числото z като адрес
                ; и записва адреса в регистъра r9
    PRINT_DEC 8, r9
    
xor rax, rax
ret