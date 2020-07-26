import socket
while(1):
    print("Dns lookup")
    print("1")
    print("2")
    print("Exit")
    choice=int(input("Enter Choice"))
    if choice==1:
      try:
        var=input("Enter URL")
        add2=socket.gethostbyname(var)
        print(add2)
      except Exception as e:
        print(e)
    elif choice==2:
      try: 
        var1 = input("Enter IP")
        add6=socket.gethostbyaddr(var1)
        print(add6)
      except Exception as e:
        print(e)
    elif choice==3:
        break
    else:
        print("enter Correct")
     
     
