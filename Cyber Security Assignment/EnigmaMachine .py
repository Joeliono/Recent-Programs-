import string
import tkinter.ttk
import tkinter as tk
from string import *



alphabetlist = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"]
plugboard = ["Z", "P", "H", "N","M", "S", "W", "C", "I", "Y", "T", "Q", "E", "D", "O", "B", "L", "R", "F", "K", "U", "V", "G", "X", "J","A"]

rotorI = ["E", "K", "M", "F", "L", "G", "D", "Q", "V", "Z", "N", "T", "O", "W", "Y", "H", "X", "U", "S", "P", "A", "I", "B", "R", "C", "J"]
rotorII = ["A", "J", "D", "K", "S", "I", "R", "U", "X", "B", "L", "H", "W", "T", "M", "C", "Q", "G", "Z", "N", "P", "Y", "F", "V", "O", "E"]
rotorIII = ["B", "D", "F", "H", "J", "L", "C", "P", "R", "T", "X", "V", "Z", "N", "Y", "E", "I", "W", "G", "A", "K", "M", "U", "S", "Q", "O"]
rotorIV = ["E", "S", "O", "V", "P", "Z", "J", "A", "Y", "Q", "U", "I", "R", "H", "X", "L", "N", "F", "T", "G", "K", "D", "C", "M", "W", "B"]
rotorV = ["V", "Z", "B", "R", "G", "I", "T", "Y", "U", "P", "S", "D", "N", "H", "L", "X", "A", "W", "M", "J", "Q", "O", "F", "E", "C", "K"]

#This is so that the GUI would recognise rotorI as "RotorI" rather than "E,K,M...." for example
rotor_dictionary = {"RotorI":rotorI,"RotorII":rotorII,"RotorIII":rotorIII,"RotorIV":rotorIV,"RotorV":rotorV}

reflectorA = ["E","J","M","Z","A","L","Y","X","V","B","W","F","C","R","Q","U","O","N","T","S","P","I","K","H","G","D"]
reflectorB = ["Y","R","U","H","Q","S","L","D","P","X","N","G","O","K","M","I","E","B","F","Z","C","W","V","J","A","T"]
reflector_dictionary = {"ReflectorA":reflectorA,"ReflectorB":reflectorB}

#make root and main page
root = tk.Tk()
canvas = tk.Canvas(root, width=1720, height=900)

#main GUI is made here
user_input = tk.Text(root, font='Arial 10')
user_input.place(x = 350, y = 400, width=400, height=200)
input_label = tk.Label(root, text="Input plaintext here:")
input_label.place(x = 350, y = 375)

user_output = tk.Text(root, font='Arial 10')
user_output.place(x = 950, y = 400, width=400, height=200)
output_label = tk.Label(root, text="Ciphertext will be output here:")
output_label.place(x = 950, y = 375)



slow_select = tk.ttk.Combobox(root, value=list(rotor_dictionary))
slow_select.place(x = 480, y = 100)

slow_label = tk.Label(root,text="Please set the slow rotor:")
slow_label.place(x = 480, y =75)

slow_position = tk.ttk.Combobox(root, value=list(alphabetlist))
slow_position.place(x = 480, y = 200)

pos1_label = tk.Label(root,text="Set the position of the slow rotor:")
pos1_label.place(x = 475, y =175)


middle_select = tk.ttk.Combobox(root, value=list(rotor_dictionary))
middle_select.place(x = 780, y = 100)

middle_label = tk.Label(root,text="Please set the middle rotor:")
middle_label.place(x = 780, y =75)

middle_position = tk.ttk.Combobox(root, value=list(alphabetlist))
middle_position.place(x = 780, y = 200)

pos2_label = tk.Label(root,text="Set the position of the middle rotor:")
pos2_label.place(x = 775, y =175)

fast_select = tk.ttk.Combobox(root, value=list(rotor_dictionary))
fast_select.place(x = 1080, y = 100)

fast_label = tk.Label(root,text="Please set the fast rotor:")
fast_label.place(x = 1080, y =75)

fast_position = tk.ttk.Combobox(root, value=list(alphabetlist))
fast_position.place(x = 1080, y = 200)

pos3_label = tk.Label(root,text="Set the position of the fast rotor:")
pos3_label.place(x = 1075, y =175)

reflector_select = tk.ttk.Combobox(root, value=list(reflector_dictionary))
reflector_select.place(x = 635, y = 300)

reflector_label = tk.Label(root, text="Please select a reflector:")
reflector_label.place(x = 635, y = 275)

#The main method that handles the encryption/decryption processs
def encrypt_or_decrypt():
    encrypt_list = []
    #set the index to what the user assigns
    index_rotor1 = alphabetlist.index(fast_position.get())
    index_rotor2 = alphabetlist.index(middle_position.get())
    index_rotor3 = alphabetlist.index(slow_position.get())

    #This is to pick up the input
    to_encrypt = list(user_input.get("1.0","end-1c"))

    #set our rotors and reflector to what the user chose
    fast_rotor = rotor_dictionary.get(fast_select.get())
    middle_rotor = rotor_dictionary.get(middle_select.get())
    slow_rotor = rotor_dictionary.get(slow_select.get())

    reflector = reflector_dictionary.get(reflector_select.get())

    for char in to_encrypt:

        if char in alphabetlist:

            #This is to facilitate the rotor movement after each cycle is done
            if index_rotor1 % 25 == 0 and index_rotor1 > 0:
                index_rotor1 = 0
                index_rotor2 += 1
                middle_position.set(alphabetlist[index_rotor2 % 26]) #make sure to do modulo 26 so it doesn't overflow
            else: #rotor1/fast rotor should usually go up by one
                index_rotor1 += 1

            if index_rotor2 % 26 == 0 and index_rotor2 > 0:
                index_rotor2 = 0
                index_rotor3 += 1
                slow_position.set(alphabetlist[index_rotor3 % 26])

            if index_rotor3 % 26 == 0:
                index_rotor3 = 0
                slow_position.set(alphabetlist[index_rotor3 % 26])
            #Example with encrypting the letter A with our fast as RotorI,middle as RotorII,slow as RotorIII all in their base positions:

            char = plugboard[alphabetlist.index(char) % 26] #start with plugboard encryption e.g A -> Z
            plugboard_encryption = char

            fast_position.set(alphabetlist[index_rotor1 % 26] ) #Updates position in GUI
            current_pos1 = (alphabetlist.index(char) + index_rotor1) % 26 #makes the current position of the rotor in this case to B
            char = fast_rotor[current_pos1] # A is encrypted to E
            char = alphabetlist[((alphabetlist.index(char) - index_rotor1) + index_rotor2) % 26] # This changes E to D for the next rotor


            current_pos2 = (alphabetlist.index(char))
            char = middle_rotor[current_pos2] #D is encrypted to K
            char = alphabetlist[((alphabetlist.index(char) - index_rotor2) + index_rotor3 )% 26] #K is set to K as both rotors haven't moved


            current_pos3 = (alphabetlist.index(char))
            char = slow_rotor[current_pos3] #K encrypts to X


            char = reflector[(alphabetlist.index(char) - index_rotor3) % 26] #Reflector substitutes X to J


            char = alphabetlist[(alphabetlist.index(char) + index_rotor3) % 26]
            char = alphabetlist[slow_rotor.index(char)] #We work backwards so J is now E


            char = alphabetlist[((alphabetlist.index(char) + index_rotor2) - index_rotor3) % 26]
            char = alphabetlist[middle_rotor.index(char)] #Now E is encrypted to Z


            char = alphabetlist[((alphabetlist.index(char) + index_rotor1) - index_rotor2) % 26] #Changed back to A as fast rotor has moved
            char = alphabetlist[fast_rotor.index(char)] # A changes to U


            char = alphabetlist[(alphabetlist.index(char) - index_rotor1) % 26] #U changes to T

            char = alphabetlist[plugboard.index(char) % 26] #Plugboard encrypts T to K


            encrypt_list.append(char) # Append encrypted characters in a list
            print( "current rotor1 pos: " + alphabetlist[index_rotor1% 26] )
            print( "current rotor2 pos: " + alphabetlist[index_rotor2% 26])
            print("current rotor3 pos: " + alphabetlist[index_rotor3% 26])
            print(encrypt_list)

    ciphertext= "".join(encrypt_list) #Join the elements in the list and make them one string
    user_output.delete(1.0,"end") #Delete the old items in the text field
    user_output.insert(1.0,ciphertext) #Insert the new ciphertext in the text field


run_txt = tk.StringVar()
run_btn = tk.Button(root, textvariable=run_txt, font='Arial', command=encrypt_or_decrypt) #Button that runs the method
run_txt.set("Encrypt/Decrypt")
run_btn.grid(column=1, row=2)

canvas.grid(columnspan=3, rowspan=3)

root.mainloop()
