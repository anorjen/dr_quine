default rel
extern printf, exit

;comment1
section .data
    format db "default rel%1$cextern printf, exit%1$c%1$c;comment1%1$csection .data%1$c    format db %2$c%3$s%2$c,0%1$c%1$csection .text%1$cglobal main%1$cmain:%1$c    sub   rsp, 8%1$c    call  print ;comment2%1$c    xor   eax, eax%1$c    add   rsp, 8%1$c    ret%1$c%1$cprint:%1$c    sub   rsp, 8%1$c    lea   rdi, [rel format]%1$c    mov   rsi, 10%1$c    mov   rdx, 34%1$c    lea   rcx, [rel format]%1$c    mov   rax, 0%1$c    call  printf%1$c    add   rsp, 8%1$c    ret%1$c",0

section .text
global main
main:
    sub   rsp, 8
    call  print ;comment2
    xor   eax, eax
    add   rsp, 8
    ret

print:
    sub   rsp, 8
    lea   rdi, [rel format]
    mov   rsi, 10
    mov   rdx, 34
    lea   rcx, [rel format]
    mov   rax, 0
    call  printf
    add   rsp, 8
    ret
