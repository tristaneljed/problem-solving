#include<stdio.h>
#define MAX 100

void reverse(char* str)
{
	int len=0, i=0;
	char temp;
	while(str[len]!='\0')
		len++;
	len--;
	while(i<len) {
		temp = str[i];
		str[i] = str[len];
		str[len] = temp;
		i++;
		len--;
	}
}

int main()
{
	char str[MAX];
	printf("Enter the string:");
	scanf("%s",str);
	reverse(str);
	printf("Reverse:%s\n",str);
	return 0;
}
