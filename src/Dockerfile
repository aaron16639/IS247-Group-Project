# Start from an official Java 25 image (includes JDK with javac)
FROM eclipse-temurin:25-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy your Java source files into the container
COPY . .

# Compile all .java files, output .class files into /app/out
RUN find . -name "*.java" > sources.txt && javac -d out @sources.txt

# Run your program — REPLACE Main with your actual main class name
CMD ["java", "-cp", "out", "Main"]