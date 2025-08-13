;Примерно съдържание на прозореца Input:
;1 -2 3 -4 5
;   6 -7 8 -9 10

;Съответен извеждан текст в прозореца Output:
;Sum: 11
;1 + -2 + 3 + -4 + 5 + 6 + -7 + 8 + -9 + 10   =   11
;1 + -2 + 3 + -4 + 5 + 6 + -7 + 8 + -9 + 10   =   11

%include  "io64.inc"
  Len equ 10
section .data
    s       db "Sum: ", 0
section .bss
    nums    resq Len
section .text
global main
main:
        mov rcx, Len
    step1:      GET_DEC 8, [nums + rcx*8 - 8]
            loop toStep1
            jmp after1 ; безусловен преход
    toStep1:jmp step1
    after1:
    
    xor rax, rax
        mov rcx, Len ; записва втория операнд в първия
    step2:      add rax, [nums + rcx*8 - 8]
            loop step2
         
    PRINT_STRING [s]   
    PRINT_DEC 8, rax
    NEWLINE
    
     ; следва обхождане по намаляващи индекси на числа от редицата
        mov rcx, Len
        lea r9, [s0] ; записва адреса на 2-я операнд в 1-я
    step3:      PRINT_STRING [r9]
                lea r9, [opS] ; записва адреса opS в регистъра r9
                PRINT_DEC 8, [nums + rcx*8 - 8]
            dec rcx ; намалява rcx с единица
            jnz step3 ; преход при ненулев резултат от dec rcx
    PRINT_STRING [eql]   
    PRINT_DEC 8, rax
    NEWLINE
    
     ; следва обхождане по намаляващи адреси на числа от редицата
        lea rsi, [nums + 8 * (Len - 1)] ; записва в rsi адреса nums+8*(Len-1)
        ;mov rsi, nums + 8 * (Len - 1) ; записва в rsi числото nums+8*(Len-1)
        lea r9, [s02] ; интерпретира s02 като адрес и го записва в r9
        ;mov r9, s02 ; интерпретира s02 като число и го записва в r9
    step4:      PRINT_STRING [r9]
                lea r9, [opS2]
                PRINT_DEC 8, [rsi]
            sub rsi, 8 ; записва в rsi разликата rsi-8
            cmp rsi, nums ; интерпретира nums като число и го изважда от rsi
                          ; без да съхранява резултата, но модифицира флагове
            jge step4 ; преход при rsi>=nums
    PRINT_STRING [s1]   
    PRINT_DEC 8, rax 
    NEWLINE
    
xor eax, eax
ret
section .data
    opS     db " + " ; opS е адрес на низ " + " последван от 0
    s0      db 0 ; s0 е адрес на празен низ
    s1      db "   =   ", 0
    opS2    db " + ", 0
  s02 equ $ - 1 ; $ е адрес на байта непосредствено след
                ; последния разположен в паметта код
      ; s02 е число, равно на адреса на празен низ
    



