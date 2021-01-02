section .data
format: db "section .data%1$cformat: db %2$c%3$s%2$c,0%1$cfname: db 'Sully_ .s',0%1$ccmd: db 'nasm -felf64 Sully_ .s && gcc -o Sully_  -no-pie Sully_ .o && ./Sully_ ',0%1$csection .text%1$cglobal main%1$cextern open%1$cextern dprintf%1$cextern system%1$c%1$cmain:%1$cpush rbp%1$cmov rbp, rsp%1$cmov rax, %4$c%1$cadd rax, 48%1$ccmp rax, 48%1$cjbe exit%1$csub rax, 1%1$cmov r9, rax%1$clea rdi, [rel fname + 6]%1$cstosb%1$clea rdi, [rel cmd + 19]%1$cstosb%1$cadd rdi, 19%1$cstosb%1$cadd rdi, 15%1$cstosb%1$cadd rdi, 14%1$cstosb%1$clea rdi, [rel fname]%1$cmov rsi, 0x241%1$cmov rdx, 0o774%1$ccall open%1$ccmp rax, 0xfffffff%1$cjge exit%1$cmov rdi, rax%1$clea rsi, [rel format]%1$cmov rdx, 10%1$cmov rcx, 34%1$clea r8, [rel format]%1$ccall dprintf%1$clea rdi, [rel cmd]%1$ccall system%1$cexit:%1$cleave%1$cret%1$c",0
fname: db 'Sully_ .s',0
cmd: db 'nasm -felf64 Sully_ .s && gcc -o Sully_  -no-pie Sully_ .o && ./Sully_ ',0
section .text
global main
extern open
extern dprintf
extern system

main:
push rbp
mov rbp, rsp
mov rax, 5
add rax, 48
cmp rax, 48
jbe exit
sub rax, 1
mov r9, rax
lea rdi, [rel fname + 6]
stosb
lea rdi, [rel cmd + 19]
stosb
add rdi, 19
stosb
add rdi, 15
stosb
add rdi, 14
stosb
lea rdi, [rel fname]
mov rsi, 0x241
mov rdx, 0o774
call open
cmp rax, 0xfffffff
jge exit
mov rdi, rax
lea rsi, [rel format]
mov rdx, 10
mov rcx, 34
lea r8, [rel format]
call dprintf
lea rdi, [rel cmd]
call system
exit:
leave
ret
