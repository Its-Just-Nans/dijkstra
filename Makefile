all: build run

build:
	find -name "*.java" > sources.txt
	javac @sources.txt -d bin
	cd bin; find -name "*.class" > ../sourcesClass.txt
	cd bin; jar -cfvm ../dijkstra.jar ../MANIFEST.MF @../sourcesClass.txt
	rm sources.txt
	rm sourcesClass.txt

run:
	java -jar dijkstra.jar