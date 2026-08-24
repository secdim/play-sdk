APP=secdim.lab.kotlin
.SILENT:
.PHONY: all build test securitytest clean header run debug push status reset

all: build

test: build header
	echo -e "\033[1;33m\n[i] Running functionality tests\033[0m\n"
	docker run --rm ${APP} sh -c "gradle --no-daemon --info test" \
		&& echo -e "\033[1;32m\n[i] Well done! All functionality tests have been passed\033[0m\n"\
		|| (echo -e "\033[1;31m\n[!] Oh, no! Program has functionality bug(s)! Try again\033[0m\n"; exit 1)

securitytest: build header
	echo -e "\033[1;33m\n[i] Running security tests\033[0m\n"
	docker run --rm ${APP} sh -c "gradle --no-daemon --info securityTest" \
		&& echo -e "\033[1;32m\n[i] Well done! All security tests have been passed\033[0m\n"\
		|| (echo -e "\033[1;31m\n[!] Oh, no! Program has security bug(s)! Try again\033[0m\n"; exit 1)

build: header
	echo -e "\033[1;33m\n[i] Building the program\033[0m\n"
	docker build --rm --tag=$(APP) .
	echo -e "\033[1;32m\n[i] Done! Program is ready to run\033[0m\n"

run: build
	docker run -it --rm $(APP)

debug: build
	docker run -it -v "${PWD}/src:/home/gradle/src" --rm ${APP} sh

clean:
	docker image rm $(APP) || true
	docker system prune -f
	docker image prune -f

push: test
	echo -e "\033[1;33m\n[i] Build, test and push to SecDim\033[0m\n"
	git add . && git commit -m 'security fix' && git push
	echo -e "\033[1;32m\n[i] Done! Checkout the challenge commits page\033[0m\n"

status:
	curl "https://play.secdim.com/play/status/$(shell git rev-parse HEAD)/username/$(word 3, $(subst /, ,$(shell git remote get-url origin)))"

reset:
	echo -e "\033[1;33m\n[i] Reseting git history\033[0m\n"
	git reset --hard $(git rev-list --max-parents=0 HEAD)
	git clean -fd
	git push -f origin master

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
