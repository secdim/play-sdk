#!/bin/bash
set -eu

# SecDim Play's SDK script.
# Version 1.0
# https://github.com/secdim/play-sdk

SDK_URL="git@gitlab.com:secdim/content/play"
LEVEL_DIR="level"

# Public domain - http://unlicense.org
# https://github.com/client9/shlib/blob/master/LICENSE.md
# but credit (and pull requests) appreciated.
# ------------------------------------------------------------------------

is_command() {
  command -v "$1" >/dev/null
}

echo_stderr() (
  echo "$@" 1>&2
)

# ------------------------------------------------------------------------
# End of functions from https://github.com/client9/shlib
# ------------------------------------------------------------------------

log_error() {
    echo_stderr "[e]" "${@}"
}

log_info() {
    echo_stderr "[i]" "${@}"
}

log_warn() {
    echo_stderr "[w]" "${@}"
}

ask () {
    printf "[?] %s: " "${@}"
}

success() {
    log_info "You can always update your SSH key on https://id.secdim.com"
    log_info "Setup is successfully completed"
    log_info "Go to https://play.secdim.com and have fun!"
    exit 0
}

get_sdk () {
    ask "Please enter the language (java, python, solidity, csharp, js, ts, go)"
    read -r lang
    log_info "Removing possible duplicate files"
    rm -rf "${lang}" "${LEVEL_DIR}"
    log_info "Copying latest SDK for ${lang}"
    cp -r "lib/${lang}" "${LEVEL_DIR}"
    rm -rf "${LEVEL_DIR}/.git"
    log_info "Done. ${lang} SDK is available in ${LEVEL_DIR}/"
}

verify () {
    cd "${LEVEL_DIR}"
    log_info "Verifying if container can be built"
    make build
    log_info "Verifing usability tests"
    make test
    log_info "Verifying security tests"
    make securitytest
    log_info "Verifying container can run"
    log_info "Please manually check if you can interact with the app"
    make run
    log_info "Verifying if patch branch exist"
    git show-ref refs/heads/patch
    log_info "Verification is complete."
}

main () {
    log_info "Please select from one of the following options"
    log_info "1) init: Start developing a new level"
    log_info "2) verify: Verify an existing level"
    log_info "0) quit"
    ask "Please choose"
    read -r answer

    case "$answer" in
		1)
			get_sdk
			;;
		2)
			verify
			;;
		*)
			exit 0
			;;
	esac
}

echo_stderr ""
echo_stderr "Welcome to SecDim Level Builder v1.0"
echo_stderr ""

main "${@}"
