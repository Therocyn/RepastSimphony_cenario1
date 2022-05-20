import socket
from threading import Thread

flagMove = False

def writing():
    global flagMove
    client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    client_socket.connect(("localhost", 5000))

    while True:
        if flagMove == True:
            print("mandando 1")
            client_socket.send(("1"+'\n').encode())


def reading():
    global flagMove
    client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    client_socket.connect(("localhost", 5001))

    while True:
        received_data = client_socket.recv(1024)
        received_data.decode()
        print(received_data.decode())
        if received_data.decode() == "1\n":
            flagMove = True
            print("ending thread")
            break


t1 = Thread(target=writing)
t1.start()
t2 = Thread(target=reading)
t2.start()

t2.join()
t1.join()



