import os.path
from os import path
from flask import Flask, request, render_template, session


app = Flask(__name__)

app.secret_key = b'\xb2C\xc8g\xe4\xe0\x89\xb5\x90\xa0\xbfF\xd7\xdb\x10\xc3'

def opener():
    try:
        file = open('assignment11-account-info.txt', 'r')
        text = file.read();
        file.close();
        
        text = text.rstrip("\n")
        
        file = open('assignment11-account-info.txt', 'w')
        file.write(text)
        file.close();


        List = text.split('\n')
        allUsers = []
    
        for sent in List:
            words = sent.split(";")
            user ={
                "username": words[0],
                "password": words[1],
                "fname": words[2],
                "lname": words[3],
                "color": words[4],
                "title": words[5],
                "imgURL": words[6]}
           
            allUsers.append(user)
        return allUsers
    except Exception as e:
        return False

def userEdit(user, username, fname, lname, color, title, imgURL):
    
    oldStr = str(user["username"]) +';'+ str(user["password"]) +';'+ str(user["fname"]) +';'+ str(user["lname"]) +';'+ str(user["color"]) +';'+ str(user["title"]) +';'+ str(user["imgURL"])
    newStr = str(username) +';'+ str(user["password"]) +';'+ str(fname) +';'+ str(lname) +';'+ str(color) +';'+ str(title) +';'+ str(imgURL)
    try:
        file = open('assignment11-account-info.txt', 'r')
        text = file.read();
        file.close();
            
        text = text.replace(oldStr, newStr)

        file = open('assignment11-account-info.txt', 'w')
        file.write(text)
        file.close()
        return {"username": username,
                "password": user["password"],
                "fname": fname,
                "lname": lname,
                "color": color,
                "title": title,
                "imgURL": imgURL}
    except Exception as e:
        print("exception occured")
        return False
    
    

def createDefaultAccount(user, pw, fname, lname):
    output = user+';'+pw+';'+fname+';'+lname+';'+"white"+';'+"Welcome to "+fname+" "+lname+"'s Assignment 11 web site!"+';'+"https://upload.wikimedia.org/wikipedia/commons/thumb/9/94/Stick_Figure.svg/1200px-Stick_Figure.svg.png"
    flag = path.exists("assignment11-account-info.txt")
    file = open('assignment11-account-info.txt', 'a')
    if(flag):
       file.write("\n")
    file.write(output)
    file.close()
    return {"username": user,
            "password": pw,
            "fname": fname,
            "lname": lname,
            "color": "white",
            "title": "Welcome to "+fname+" "+lname+"'s Assignment 11 web site!",
            "imgURL": "https://upload.wikimedia.org/wikipedia/commons/thumb/9/94/Stick_Figure.svg/1200px-Stick_Figure.svg.png"}

def findUser(allUsers, username):
    if(allUsers == False):
        return False
    for user in allUsers:
        if(user["username"] == username):
            return user;
    return False;

def existUser(allUsers, testName):
    if(allUsers == False):
        return False
    for user in allUsers:
        if(user["username"] == testName):
            return True;
    return False;

def passwordCheck(allUsers, testName, testPass):
    if(allUsers == False):
        return False
    for user in allUsers:
        if(user["username"] == testName and user["password"] == testPass):
            return user;
    return False;
 

@app.route("/")

@app.route("/assignment11.html", methods=["POST","GET"])
def pather():
    username = request.args.get('user')
    password = request.args.get('pass')
    fname = request.args.get('fname')
    lname = request.args.get('lname')
    create = request.args.get('create')
    login = request.args.get('logon')
    logout = request.args.get('logout')
    edit = request.args.get('edit')


    allUsers = opener()
  

    #Edit Account Data
    if edit != None:
        user = findUser(allUsers,username)
        user = userEdit(user, username, request.args.get('fname'), request.args.get('lname'), request.args.get('color'), request.args.get('title'), request.args.get('image'))
        if (user != False):
            session.pop('user', None)
            session['user'] = user
            return render_template('profile.html', title=user["title"], color=user["color"],fname=user["fname"],lname=user["lname"], uName=user["username"], imgURL=user["imgURL"])
        else:
            return render_template('profile.html', title=session['user']["title"], color=session['user']["color"],fname=session['user']["fname"],lname=session['user']["lname"],uName=session['user']["username"],imgURL=session['user']["imgURL"], error = "IO Exception Occurred") 

    #Logout (Ends Session)
    elif logout != None:
        session.pop('user', None)
        return render_template('assignment11.html')

    #Remembers User (Remembered Session)
    elif 'user' in session:
        return render_template('profile.html', title=session['user']["title"], color=session['user']["color"],fname=session['user']["fname"],lname=session['user']["lname"],uName=session['user']["username"],imgURL=session['user']["imgURL"]) 

    #Create Account Error Check
    elif create != None:
        if username == "":
            return render_template('assignment11.html', error="PLEASE ENTER USERNAME")
        elif password == "":
            return render_template('assignment11.html', error="PLEASE ENTER PASSWORD")
        elif fname == "":
            return render_template('assignment11.html', error="PLEASE ENTER FIRST NAME")
        elif lname == "":
            return render_template('assignment11.html', error="PLEASE ENTER LAST NAME")
        elif(existUser(allUsers, username)):
            return render_template('assignment11.html', error="USER NAME TAKEN PLEASE ENTER A NEW USERNAME")
        else:
            user = createDefaultAccount(username, password, fname, lname)
            session['user'] = user
            return render_template('profile.html', title=("Welcome to "+fname+' '+lname+"'s Assignment 11 web site!"), color="white",fname=fname,lname=lname,uName=username,imgURL="https://upload.wikimedia.org/wikipedia/commons/thumb/9/94/Stick_Figure.svg/1200px-Stick_Figure.svg.png")
            

    #Login Error Check
    elif login != None:
        if username == "":
            return render_template('assignment11.html', error="PLEASE ENTER USERNAME")
        elif password == "":
            return render_template('assignment11.html', error="PLEASE ENTER PASSWORD")
        elif(existUser(allUsers, username)==False):
            return render_template('assignment11.html', error="NO SUCH USER EXISTS")
        user = passwordCheck(allUsers,username,password)
        if user == False:
            return render_template('assignment11.html', error="PASSWORD INCORRECT")
        elif user != False:
            session['user'] = user
            return render_template('profile.html', title=user["title"], color=user["color"],fname=user["fname"],lname=user["lname"],uName=user["username"],imgURL=user["imgURL"])

    
        
        

    else:
        return render_template('assignment11.html')
    return render_template('assignment11.html')
