# nasm -f elf64 -o main.o main.asm
# gcc -no-pie -o main.out main.o
# nasm -felf64 test.s && gcc -o test  -no-pie test .o && ./test

AS = nasm

COMPILE = $(AS) -f elf64 $< -o $@.o && gcc -no-pie $@.o -o $@
PROGS = Colleen Grace Sully

all: $(PROGS)

Colleen: Colleen.s
	$(COMPILE)

Grace: Grace.s
	$(COMPILE)

Sully: Sully.s
	$(COMPILE)

clean:
	rm -f *.o
	rm -f Grace_kid.s
	rm -f Sully_*

fclean: clean
	rm -f $(PROGS)

re: fclean all

.PHONY: all clean fclean re
