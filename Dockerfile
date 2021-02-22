FROM adoptopenjdk/openjdk13-openj9

RUN groupadd --gid 1000 apprunner \
  && useradd --system -M --gid 1000 --uid 1000 appruner \
  && install -d -m 0750 -o 1000 -g 1000 /opt/app

ENV JAVA_TOOL_OPTIONS -XX:+UseContainerSupport -XX:MaxRAMPercentage=75

WORKDIR /opt/app

USER 1000

ARG DEPENDENCY=target/dependency

COPY ${DEPENDENCY}/BOOT-INF/lib lib
COPY ${DEPENDENCY}/META-INF META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes .

ENTRYPOINT exec java -classpath .:./lib/* -Duser.timezone=UTC ${JAVA_OPTS} com.nico.madry.springbanking.SpringBankingApplication