# Flood fill 8 connected polygon. Boundary color must be different from fill color
# so that we know when to stop
# Initialize seed point, fcol and dcol
def floodfill(i, j, fcol, dcol):
	if getPixel(i, j) != dcol and getPixel(i, j) != fcol:
		setPixel(i, j, fcol)
		floodfill(i, j-1, fcol, dcol) # fcol: fill color, dcol: default color
		floodfill(i, j+1, fcol, dcol)
		floodfill(i-1, j-1, fcol, dcol)
		floodfill(i-1, j, fcol, dcol)
		floodfill(i-1, j+1, fcol, dcol)
		floodfill(i+1, j-1, fcol, dcol)
		floodfill(i+1, j, fcol, dcol)
		floodfill(i+1, j+1, fcol, dcol)

