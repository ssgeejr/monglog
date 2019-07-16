FROM mongo:4.0.2

LABEL maintainer="Steve S Gee JR <steve.gee@sprint.com>"
LABEL description="fetch/insert engine for log files. part 2 of 3"

RUN apt-get update && apt-get install -y curl wget telnet iputils-ping vim && rm -rf /var/lib/apt/lists/*

CMD ["/bin/bash"]
