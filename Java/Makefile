CC = javac
COLLEEN = Colleen
GRACE = Grace
SULLY = Sully

all: $(COLLEEN) $(GRACE) $(SULLY)

$(COLLEEN): Colleen.java
	$(CC) $^

$(GRACE): Grace.java
	$(CC) $^

$(SULLY): Sully.java
	$(CC) $^

clean:
	rm -rf Grace_kid.java Sully_*

fclean: clean
	rm -rf $(COLLEEN).class $(GRACE).class $(SULLY).class

re: fclean all
