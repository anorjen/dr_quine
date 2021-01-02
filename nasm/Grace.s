;comment
section .data
format: db ";comment%1$csection .data%1$cformat: db %2$c%3$s%2$c,0%1$cfname: db 'Grace_kid.s'%1$csection .text%1$cglobal main%1$cextern open%1$cextern dprintf%1$c%1$c%4$cmacro OPEN 2%1$cmov rsi, %4$c1%1$cmov rdx, %4$c2%1$clea rdi, [rel fname]%1$ccall open%1$ccmp rax, 0xfffffff%1$cjge exit%1$c%4$cendmacro%1$c%1$c%4$cmacro WRITE 0%1$cmov rdi, rax%1$clea rsi, [rel format]%1$cmov rdx, 10%1$cmov rcx, 34%1$clea r8, [rel format]%1$cmov r9, 37%1$ccall dprintf%1$c%4$cendmacro%1$c%1$c%4$cmacro START 0%1$cmain:%1$cpush rbp%1$cmov rbp, rsp%1$cOPEN 0x241,0o774%1$cWRITE%1$cexit:%1$cleave%1$cret%1$c%4$cendmacro%1$c%1$cSTART%1$c",0
fname: db 'Grace_kid.s'
section .text
global main
extern open
extern dprintf

%macro OPEN 2
mov rsi, %1
mov rdx, %2
lea rdi, [rel fname]
call open
cmp rax, 0xfffffff
jge exit
%endmacro

%macro WRITE 0
mov rdi, rax
lea rsi, [rel format]
mov rdx, 10
mov rcx, 34
lea r8, [rel format]
mov r9, 37
call dprintf
%endmacro

%macro START 0
main:
push rbp
mov rbp, rsp
OPEN 0x241,0o774
WRITE
exit:
leave
ret
%endmacro

START
