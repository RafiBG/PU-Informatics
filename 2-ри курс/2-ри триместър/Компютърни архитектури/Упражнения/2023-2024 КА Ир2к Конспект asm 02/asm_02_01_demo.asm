;Примерно съдържание на прозореца Input:
;   250     -11
;1f   abcdefgh    ijklmn

;Съответен извеждан текст в прозореца Output:
;250 = fa
;-11 = fffffffffffffff5
;31 = 1f
;   abcdefgh    ijklmn

%include "io64.inc" ; този ред се замества
                    ; със съдържанието на файла  io64.inc
section .data ; секция за конкретни данни
    msg     db " = ", 0
section .bss ; секция за резервиране на памет
             ; (по подразбиране байтовете в нея се нулират)
    memStr  resb 100
section .text ; секция за изпълним код (инструкции)
global main ; задава входна точка за приложението
main:

    GET_DEC 8, rax ; прочита 10-ичен запис
    PRINT_DEC 8, rax ; извежда 10-ичен запис
    PRINT_STRING [msg] ; извежда низ
    PRINT_HEX 8, rax ; извежда 16-ичен запис
    NEWLINE ; извежда знакове за нов ред в изходния поток
    
    GET_DEC 8, rax
    PRINT_DEC 8, rax
    PRINT_STRING [msg] ; след последния знак на низа 
	                    ; трябва да има байт с нула
    PRINT_HEX 8, rax
    NEWLINE
    
    GET_HEX 8, rax ; прочита 16-ичен запис
    PRINT_DEC 8, rax
    PRINT_STRING [msg]
    PRINT_HEX 8, rax
    NEWLINE
    
    GET_STRING [memStr], 100 ; прочита низ и го записва
                             ; заедно с нулев байт след низа
                             ; в максимум 100 байта
    PRINT_STRING [memStr]
    NEWLINE
    
xor rax, rax ; подготвя код 0 за завършване на приложението
ret ; връща (с код 0) управлението към операционната система