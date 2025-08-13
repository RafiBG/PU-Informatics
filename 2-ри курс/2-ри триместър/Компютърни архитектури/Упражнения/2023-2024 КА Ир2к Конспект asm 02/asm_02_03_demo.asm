;Примерно съдържание на прозореца Input:
;1999 -234

;Съответен извеждан текст в прозореца Output:
;1999
;+
;-234
;=
;1765
;
;1999 + -234 = 1765

%include "io64.inc"
section .data
    s1  db " + ", 0 ; нулата след низа е признак за края му,
                    ; тя изисква явно указание за запис на 0
                    ; и е необходима за PRINT_STRING

section .bss
    nums resq 2 ; заделя място за две 8-байтови данни
section .data ; частите на една и съща секция
              ; може да бъдат в произволен ред
              ; спрямо частите на другите секции
              ; (транслаторът обединява частите
              ; на една и съща секция в едно цяло)
    s2  db " = "
        db 0
section .text
global main
main:

    GET_DEC 8, [nums]
    GET_DEC 8, [nums + 8] ; записва на адрес nums+8
    PRINT_DEC 8, [nums]
    NEWLINE
    PRINT_CHAR '+'
    NEWLINE
    PRINT_DEC 8, [nums + 8]
    NEWLINE
    PRINT_CHAR '='
    NEWLINE
    
    ; инструкция add [nums], [nums+8] е невъзможна
    ; защото в една и съща инструкция
    ; може да се указва най-много един адрес в паметта
    mov r15, [nums]
    add r15, [nums + 8] ; сумата се записва
                        ; на мястото на 1-я операнд
    
    PRINT_DEC 8, r15
    NEWLINE
    
    NEWLINE
    PRINT_DEC 8, [nums]
    PRINT_STRING [s1]
    PRINT_DEC 8, [nums + 8]
    PRINT_STRING [s2]
    PRINT_DEC 8, r15
    NEWLINE
    
xor eax, eax
ret