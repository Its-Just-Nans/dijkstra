all: build run clean

build:
	find src -name "*.java" > sources.txt
	javac @sources.txt -d bin
	cp src/ui/Drawing/logo.png bin/ui/Drawing/logo.png
	cd bin; find -name "*.*" > ../sourcesClass.txt
	cd bin; jar -cfvm ../dijkstra.jar ../MANIFEST.MF @../sourcesClass.txt

run:
	java -jar dijkstra.jar

clean:
	rm -rf bin
	rm sources.txt
	rm sourcesClass.txt