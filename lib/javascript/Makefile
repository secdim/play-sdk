APP=secdim.lab.js
.SILENT:
.PHONY: all build test securitytest clean header
all: build

test: header build
	echo -e "\033[1;33m\n[i] Running functionality tests\033[0m\n"
	docker run --rm ${APP} sh -c "npm test --forceExit --verbose app.test.js" \
		&& echo -e "\033[1;32m\n[i] Well done! All functionality tests have been passed\033[0m\n"\
		|| echo -e "\033[1;31m\n[!] Oh, no! Program has functionality bug(s)! Try again\033[0m\n"

securitytest: header build
	echo -e "\033[1;33m\n[i] Running security tests\033[0m\n"
	docker run --rm ${APP} sh -c "npm test --forceExit --verbose -t appSecurity.test.js" \
		&& echo -e "\033[1;32m\n[i] Well done! All security tests have been passed\033[0m\n"\
		|| echo -e "\033[1;31m\n[!] Oh, no! Program has security bug(s)! Try again\033[0m\n"

build: header
	echo -e "\033[1;33m\n[i] Building the program\033[0m\n"
	docker build --rm --tag=${APP} .
	echo -e "\033[1;32m\n[i] Done! Program is ready to run\033[0m\n"\

run: build
	docker run -p 8080:8080 --rm ${APP}

debug: build
	docker run -p 8080:8080 --rm -it -v "${PWD}/src:/app" -v /app/node_modules/ ${APP} sh

clean:
	docker image rm ${APP}
	docker system prune
	docker image prune -f


define HEADER

   %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
   %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
   %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
   %%%%%%%%%%%%%%              %%%%%%%%%%%%
   %%%%%%%%%%%                  ,%%%%%%%%%%
   %%%%%%%%%%         *%%%%*    %%%%%%%%%%%
   %%%%%%%%%%        %%%%%%%%%%%%%%%%%%%%%%
   %%%%%%%%%%%             *%%%%%%%%%%%%%%%
   %%%%%%%%%%%%%               .%%%%%%%%%%%
   %%%%%%%%%%%%%%%%%%            %%%%%%%%%%
   %%%%%%%%%%%%%%%%%%%%%%%        %%%%%%%%%
   %%%%%%%%%%      .%%%%.         %%%%%%%%%
   %%%%%%%%%%                   .%%%%%%%%%%
   %%%%%%%%%%%%,             ,%%%%%%%%%%%%%
   %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
   %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
              play.secdim.com
endef
export HEADER

header:
	@echo -e "\033[1;35m$$HEADER\033[0m"

push: test
	echo -e "\033[1;33m\n[i] Build, test and push to SecDim\033[0m\n"
	git add . && git commit -m 'security fix' && git push
	echo -e "\033[1;32m\n[i] Done! Checkout the challenge commits page\033[0m\n"

status:
	curl "https://play.secdim.com/play/status/$(shell git rev-parse HEAD)/username/$(word 3, $(subst /, ,$(shell git remote get-url origin)))"
