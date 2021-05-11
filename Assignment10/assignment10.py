from flask import Flask, render_template, request
import random

app = Flask(__name__)

@app.route("/")
def hello():
    return render_template("/assignment10.html")

@app.route("/assignment10.html", methods=["GET","POST"])
def form():
    method = request.method
    fname = None
    lname = None
    answer = 0
    guess = 0
    if request.method == "GET":
        answer = random.randint(1, 5)
        if "fname" in request.args:
            fname = request.args["fname"]
        if "lname" in request.args:
            lname = request.args["lname"]
            return render_template("game.html", fname=fname, lname=lname, answer=answer)
        return render_template("/assignment10.html")
    if request.method == "POST":
        if "answer" in request.form:
            answer = request.form["answer"]
        if "guess" in request.form:
            guess = request.form["guess"]
        if (answer == guess):
            return render_template("correct.html")
        else:
            return render_template("tryAgain.html", guess=guess, answer=answer)
                                  
