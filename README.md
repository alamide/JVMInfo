### 测试方法 
执行 ByteCodeRead 的  main 方法即可

### 输出示例
```
Offset  0  1  2  3  4  5  6  7  8  9  A  B  C  D  E  F
00000000 CA FE BA BE 00 00 00 3D 00 2C 0A 00 02 00 03 07
00000010 00 04 0C 00 05 00 06 01 00 10 6A 61 76 61 2F 6C
00000020 61 6E 67 2F 4F 62 6A 65 63 74 01 00 06 3C 69 6E
00000030 69 74 3E 01 00 03 28 29 56 09 00 08 00 09 07 00
00000040 0A 0C 00 0B 00 0C 01 00 1A 63 6F 6D 2F 61 6C 61
00000050 6D 69 64 65 2F 6A 76 6D 2F 48 65 6C 6C 6F 57 6F
00000060 72 6C 64 01 00 05 63 6F 75 6E 74 01 00 01 49 09
00000070 00 0E 00 0F 07 00 10 0C 00 11 00 12 01 00 10 6A
00000080 61 76 61 2F 6C 61 6E 67 2F 53 79 73 74 65 6D 01
00000090 00 03 6F 75 74 01 00 15 4C 6A 61 76 61 2F 69 6F
000000A0 2F 50 72 69 6E 74 53 74 72 65 61 6D 3B 08 00 14
000000B0 01 00 0A 53 61 79 20 48 65 6C 6C 6F 21 0A 00 16
000000C0 00 17 07 00 18 0C 00 19 00 1A 01 00 13 6A 61 76
000000D0 61 2F 69 6F 2F 50 72 69 6E 74 53 74 72 65 61 6D
000000E0 01 00 07 70 72 69 6E 74 6C 6E 01 00 15 28 4C 6A
000000F0 61 76 61 2F 6C 61 6E 67 2F 53 74 72 69 6E 67 3B
00000100 29 56 07 00 1C 01 00 14 6A 61 76 61 2F 69 6F 2F
00000110 53 65 72 69 61 6C 69 7A 61 62 6C 65 07 00 1E 01
00000120 00 13 6A 61 76 61 2F 6C 61 6E 67 2F 43 6C 6F 6E
00000130 65 61 62 6C 65 01 00 03 54 41 47 01 00 0D 43 6F
00000140 6E 73 74 61 6E 74 56 61 6C 75 65 03 00 00 00 01
00000150 01 00 04 43 6F 64 65 01 00 0F 4C 69 6E 65 4E 75
00000160 6D 62 65 72 54 61 62 6C 65 01 00 12 4C 6F 63 61
00000170 6C 56 61 72 69 61 62 6C 65 54 61 62 6C 65 01 00
00000180 04 74 68 69 73 01 00 1C 4C 63 6F 6D 2F 61 6C 61
00000190 6D 69 64 65 2F 6A 76 6D 2F 48 65 6C 6C 6F 57 6F
000001A0 72 6C 64 3B 01 00 08 73 61 79 48 65 6C 6C 6F 01
000001B0 00 08 67 65 74 43 6F 75 6E 74 01 00 03 28 29 49
000001C0 01 00 0A 53 6F 75 72 63 65 46 69 6C 65 01 00 0F
000001D0 48 65 6C 6C 6F 57 6F 72 6C 64 2E 6A 61 76 61 00
000001E0 21 00 08 00 02 00 02 00 1B 00 1D 00 02 00 1A 00
000001F0 1F 00 0C 00 01 00 20 00 00 00 02 00 21 00 02 00
00000200 0B 00 0C 00 00 00 03 00 01 00 05 00 06 00 01 00
00000210 22 00 00 00 38 00 02 00 01 00 00 00 0A 2A B7 00
00000220 01 2A 03 B5 00 07 B1 00 00 00 02 00 23 00 00 00
00000230 0A 00 02 00 00 00 0A 00 04 00 0D 00 24 00 00 00
00000240 0C 00 01 00 00 00 0A 00 25 00 26 00 00 00 09 00
00000250 27 00 06 00 01 00 22 00 00 00 25 00 02 00 00 00
00000260 00 00 09 B2 00 0D 12 13 B6 00 15 B1 00 00 00 01
00000270 00 23 00 00 00 0A 00 02 00 00 00 10 00 08 00 11
00000280 00 01 00 28 00 29 00 01 00 22 00 00 00 2F 00 01
00000290 00 01 00 00 00 05 2A B4 00 07 AC 00 00 00 02 00
000002A0 23 00 00 00 06 00 01 00 00 00 14 00 24 00 00 00
000002B0 0C 00 01 00 00 00 05 00 25 00 26 00 00 00 01 00
000002C0 2A 00 00 00 02 00 2B
------------------------------------------------------------------------------------------
This part is magic, byte index from 0 to 4
Start location is Point: (00000000, 0)
End   location is Point: (00000000, 4)

MAGIC: CAFEBABE
------------------------------------------------------------------------------------------
This part is minor_version + major_version, byte index from 4 to 8
Start location is Point: (00000000, 4)
End   location is Point: (00000000, 8)

Version: 61.0
------------------------------------------------------------------------------------------
This part is constant_pool, byte index from 8 to 479
Start location is Point: (00000000, 8)
End   location is Point: (000001D0, F)

ConstantPoolCount: 43
#1 = MethodRef           #2.#3               // java/lang/Object.<init>:()V
#2 = Class               #2                  // java/lang/Object
#3 = NameAndType         #5.#6               // <init>:()V
#4 = Utf8                java/lang/Object
#5 = Utf8                <init>
#6 = Utf8                ()V
#7 = FieldRef            #8.#9               // com/alamide/jvm/HelloWorld.count:I
#8 = Class               #8                  // com/alamide/jvm/HelloWorld
#9 = NameAndType         #11.#12             // count:I
#10 = Utf8                com/alamide/jvm/HelloWorld
#11 = Utf8                count
#12 = Utf8                I
#13 = FieldRef            #14.#15             // java/lang/System.out:Ljava/io/PrintStream;
#14 = Class               #14                 // java/lang/System
#15 = NameAndType         #17.#18             // out:Ljava/io/PrintStream;
#16 = Utf8                java/lang/System
#17 = Utf8                out
#18 = Utf8                Ljava/io/PrintStream;
#19 = String              #20                 // Say Hello!
#20 = Utf8                Say Hello!
#21 = MethodRef           #22.#23             // java/io/PrintStream.println:(Ljava/lang/String;)V
#22 = Class               #22                 // java/io/PrintStream
#23 = NameAndType         #25.#26             // println:(Ljava/lang/String;)V
#24 = Utf8                java/io/PrintStream
#25 = Utf8                println
#26 = Utf8                (Ljava/lang/String;)V
#27 = Class               #27                 // java/io/Serializable
#28 = Utf8                java/io/Serializable
#29 = Class               #29                 // java/lang/Cloneable
#30 = Utf8                java/lang/Cloneable
#31 = Utf8                TAG
#32 = Utf8                ConstantValue
#33 = Integer             1
#34 = Utf8                Code
#35 = Utf8                LineNumberTable
#36 = Utf8                LocalVariableTable
#37 = Utf8                this
#38 = Utf8                Lcom/alamide/jvm/HelloWorld;
#39 = Utf8                sayHello
#40 = Utf8                getCount
#41 = Utf8                ()I
#42 = Utf8                SourceFile
#43 = Utf8                HelloWorld.java

------------------------------------------------------------------------------------------
This part is access_flags + this_class + super_class + interfaces, byte index from 479 to 491
Start location is Point: (000001D0, F)
End   location is Point: (000001E0, B)

AccessFlags: ACC_PUBLIC ACC_SUPER
This Class: com/alamide/jvm/HelloWorld
Super Class: java/lang/Object
Interface Count: 2
[java/io/Serializable, java/lang/Cloneable]
public  class com/alamide/jvm/HelloWorld extends java/lang/Object implements java/io/Serializable, java/lang/Cloneable
------------------------------------------------------------------------------------------
This part is fields_info, byte index from 491 to 517
Start location is Point: (000001E0, B)
End   location is Point: (00000200, 5)

AccessFlags: private static final
Descriptor: I
Name: TAG
private static final I TAG
AccessFlags: private
Descriptor: I
Name: count
private I count

------------------------------------------------------------------------------------------
This part is method_info, byte index from 517 to 701
Start location is Point: (00000200, 5)
End   location is Point: (000002B0, D)

[<init>:()V, sayHello:()V, getCount:()I]
------------------------------------------------------------------------------------------
This part is attribute_info, byte index from 701 to 711
Start location is Point: (000002B0, D)
End   location is Point: (000002C0, 7)
```