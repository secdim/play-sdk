# SecDim Play Level Builder

It is very easy to make game levels for SecDim Play.
A level is a program with tests suites and runs in a container.

## Step 1: Pre-requisites

Fork and clone this repository.

Install the required tools: `docker`, `docker-compose`, and `make`
and development environment for the language that you are going to
build a level.

## Step 2: Initialise

Run `./build.sh` > init > Choose a language

To get SDK for the language you are building a level.
Currently supported languages are:

`python (py)`, `go`, `typescript (ts)`, `javascript (js) `,
`C# (csharp)`, `java`, `solidity (sol)`

## Step 3: Create a private repository

Create a private repository on github and clone it.

```
cd ../
git clone github.com/my-user/my-private-repo
```

From SDK copy level directory and `build.sh` to your private
repository.

```
cp -r ../sdk/level .
cp ../sdk/build.sh .
```

## Step 4: Build the level

Each level contains the vulnerable app and two tests suits: usability
and security.

Usability tests are always given to the player,
while security tests, depending on the level difficulty, may not be given.
The player will run `make test` to run usability test suite,
`make securitytest` to run security test suite.

You can find a sample vulnerable app and tests suits in the provided SDK.

Start by building the vulnerable app, complete usability test suites
and lastly security tests suites.

**Make sure usability tests always pass.**

## Step 5: Create a patch version

Create a new branch called `patch` and include
a patched version of the vulnerable app.

**The patched version must pass all usability and security tests.**

This patched branch will NOT be provided to the players and
it is only used to verify if level is solvable.

## Step 6: Verify

* [ ] `./build.sh` > verify: to verify if everything is okay
* [ ] Update `Readme.adoc` (NOT `README.md`) with a challenge story, level and any pre-requisites.
* [ ] Remove unnecessary files and directories

## Step 7: Push

git push both master and `patch` branches.

```
git push
git push -u origin path
```

Add `secdim` as one of the contributers to your private repository.
A friendly SecDim team member will review your level
and will be in touch for the next step.

## Done!
