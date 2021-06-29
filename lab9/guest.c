#include <stdio.h>
#include <string.h>
#include <stdlib.h>
char *sec = "\x3a\x3d\x33\x2d\x4\x7\x19\x1f\x17\x0\x1e\x6\x6\x15\x19\x2\x6\x3\x11\x13\x29\x10\x10\x28\x19\x1\xd\x1c";

void error() {
	printf("error\n");
	exit(0);
}

void success() {
	printf("success\n");
}

int main(int argc, char *argv[]){
  char* mySecret = "SQLABZODFISGOD";
  int i;
  if(argc != 2) {
	printf("give somethongs\n");
	exit(0);
  }

  for(i = 0 ; i < 28 ; i ++) {
	if( sec[i] != ( (argv[1][i]  ) ^ (mySecret[(i + 2) % strlen(mySecret)] ^ 0x30 ))) {
		error();
	}
  }
  success();
  return 0;
}

