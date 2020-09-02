#include<stdio.h>

void hamm_gen()
{
    int data[7], i;
    printf("\nEnter DataWord (4 bit) separated by space : ");
    scanf("%d %d %d %d", &data[0], &data[1], &data[2], &data[4]);

    data[6] = data[4] ^ data[2] ^ data[0];
    data[5] = data[4] ^ data[1] ^ data[0];
    data[3] = data[2] ^ data[1] ^ data[0];

    printf("\nCodeWord is %d%d%d%d%d%d%d\n", data[0], data[1], data[2], data[3], data[4], data[5], data[6]);
}

void hamm_det()
{
    int i, rec[7], c, c1, c2, c4;
    printf("\nEnter Codeword for checking : ");
    for (i = 0; i < 7; i++)
    {
        scanf("%d", &rec[i]);
    }
    c1 = rec[6] ^ rec[4] ^ rec[2] ^ rec[0];
    c2 = rec[5] ^ rec[4] ^ rec[1] ^ rec[0];
    c4 = rec[3] ^ rec[2] ^ rec[1] ^ rec[0];
    c = c4*4 + c2*2 + c1*1;

    if(c==0)
    {
        printf("\nNo Error Detected!..Entered Codeword is correct..\n");
    }
    else if(c!=0)
    {
        printf("\nError detected at position: %d\n",(7-c));
        if (rec[7-c]==0)
        {
            rec[7-c] = 1;
        }else{
            rec[7-c] = 0;
        }
        printf("\nCorrected code word is : ");
        for (i = 0; i < 7; i++)
        {
            printf("%d", rec[i]);
        }
        printf("\n");
    }
}

int main()
{
    int ch;
    do
    {
        printf("\n1: For Hamming Code Generation");
        printf("\n2: For Hamming Code Detection/Correction");
        printf("\n3: Exit");
        printf("\nEnter your choice : ");
        scanf("%d", &ch);
        if(ch==1)
        {
            hamm_gen();
        }
        if(ch==2)
        {
            hamm_det();
        }
        if(ch==3)
            break;
    }while(ch!=3);
    return 0;
}