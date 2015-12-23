#!/usr/bin/python

from time import clock
def getResult(function, *args):
	tick = clock()
	print("Solution :", function(*args))
	tick = clock() - tick
	print("Time: " + str(tick) + "\n")
	return

def takeTime(function, *args):
	tick = clock()
	function(*args)
	tick = clock() - tick
	print("Time: " + str(tick) + "\n")
	return