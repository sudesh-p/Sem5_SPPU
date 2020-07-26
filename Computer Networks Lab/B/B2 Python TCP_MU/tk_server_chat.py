
from socket import AF_INET, socket, SOCK_STREAM
from threading import Thread
from random import randint

def accept_incoming_connections():
    
    while True:
        client, client_address = SERVER.accept()
        print("{} has connected.".format(client_address))
        client.send(bytes("Type your name first to start the chat", "utf8"))
        addresses[client] = client_address
        Thread(target=handle_client, args=(client,)).start()


def handle_client(client):  
    

    name = client.recv(1024).decode("utf8")
    welcome = 'Welcome %s! \nnote: type {quit} to exit.' % name
    client.send(bytes(welcome, "utf8"))
    msg = "{} has joined the chat!".format(name)
    broadcast(bytes(msg, "utf8"))
    clients[client] = name

    while True:
        msg = client.recv(1024)
        if msg != bytes("{quit}", "utf8"):
            broadcast(msg, name+": ")
        else:
            client.send(bytes("{quit}", "utf8"))
            client.close()
            del clients[client]
            broadcast(bytes("%s has left the chat." % name, "utf8"))
            break


def broadcast(msg, prefix=""):  
    

    for sock in clients:
        sock.send(bytes(prefix, "utf8")+msg)

        
clients = {}
addresses = {}

host = '127.0.0.1'
port = randint(1024,9999)
ADDR = (host,port)

SERVER = socket(AF_INET, SOCK_STREAM)
SERVER.bind(ADDR)

if __name__ == "__main__":
    SERVER.listen(10)
    print('TCP chat server started on \nhost: ',host,'\nport: ',port)
    print("Waiting for connection...")
    ACCEPT_THREAD = Thread(target=accept_incoming_connections)
    ACCEPT_THREAD.start()
    ACCEPT_THREAD.join()
    SERVER.close()

