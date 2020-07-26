#include<sys/types.h>
#include<sys/socket.h>
#include<stdio.h>
#include<netinet/in.h> 
#include <unistd.h>
#include<string.h> 
#include<strings.h>
#include <arpa/inet.h>

//#define buffsize  150
void main()
{
int b,sockfd,sin_size,con,n,len;
//char buff[256];

char operator;
int op1,op2,result;

if((sockfd=socket(AF_INET,SOCK_STREAM,0))>0) //The socket() system call creates a new socket
printf("socket created sucessfully\n");
//printf("%d\n", sockfd);
struct sockaddr_in servaddr;

servaddr.sin_family=AF_INET;
servaddr.sin_addr.s_addr=inet_addr("127.0.0.1");
servaddr.sin_port=6006;

sin_size = sizeof(struct sockaddr_in);
if((con=connect(sockfd,(struct sockaddr *) &servaddr, sin_size))==0); //initiate a connection on a socket
printf("connect sucessful\n");
int flag=0;

while(1)
{
	
	
	printf("\n Addition:-'+' \n Subtraction:'-' \n Division:-'/' \n Multiplication:-'*' \n EXIT:-'q'\n");
	printf("\nEnter operator:");
	scanf("%s",&operator);
	if(operator=='q')
	{
		flag=1;
		write(sockfd,&operator,sizeof(operator));
		break;
	}
	printf("Enter operands:\n");
	scanf("%d %d", &op1, &op2);

	write(sockfd,&operator,sizeof(operator));
	write(sockfd,&op1,sizeof(op1));
	write(sockfd,&op2,sizeof(op2));
	
	read(sockfd,&result,sizeof(result)); 
	if(operator!='q')
		printf("Operation result from server=%d\n",result);
	


}
if(flag==1) 
{ 
	printf("\nExiting............\n");
	close(sockfd);
}
}
