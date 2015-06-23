import sys

class Number():
	def __init__(self):
		self.num = 0
		self.digits = 1

def bindigits(num):
	if num == 0:
		return 0
	i = 1
	limit = 2**i
	while limit <= num :
		i += 1
		limit = 2**i
	return i-1

def update(dlist):
	dig = dlist[0].digits
	val = 2**(dig)
	for i in range(len(dlist)):
		dlist[i].num -= val
		dlist[i].digits = bindigits(dlist[i].num)

	return [dlist, dig]

def disp(dlist):
	print "***********"
	for node in dlist:
		print node.num,":",node.digits
	print "***********"

def solve(dlist):
	dlist.sort(key=lambda x: x.digits, reverse=True)
	start = 0
	end = 0
	for i in range(1,len(dlist)):
		if (dlist[i-1].digits == dlist[i].digits):
			end = i
		else:
			if (end - start > 0):
				break;
			else:
				start = i
				end = i
	dlist = dlist[start:end+1]
	[dlist,dig] = update(dlist)
	if (dig == 0 or (end == start)):
		return 0
	else:
		return (2**dig) + solve(dlist)

def main():
	size = int(sys.stdin.readline().strip())
	data = map(int, sys.stdin.readlines())
	dlist = []
	for num in data:
		numb = Number()
		numb.num = num
		numb.digits = bindigits(num)
		dlist.append(numb)
	print solve(dlist)


if __name__ == '__main__':
	main()
