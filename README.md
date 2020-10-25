Demo Cars service
==================================================

This project was originated from sample code coming from AWS CodeDeploy.
This project is deployed by AWS CodeDeploy and AWS CloudFormation to an Amazon EC2 server.

What's Here
-----------

This sample includes:

* README.md - this file
* appspec.yml - this file is used by AWS CodeDeploy when deploying the web
  service to EC2
* buildspec.yml - this file is used by AWS CodeBuild to build the web
  service
* pom.xml - this file is the Maven Project Object Model for the web service
* src/main - this directory contains your Java service source files
* src/test - this directory contains your Java service unit test files
* scripts/ - this directory contains scripts used by AWS CodeDeploy when
  installing and deploying your service on the Amazon EC2 instance
* template.yml - this file contains the description of AWS resources used by AWS
  CloudFormation to deploy your infrastructure
* template-configuration.json - this file contains the project ARN with placeholders used for tagging resources with the project ID

# Getting Started

Deploying locally

1. Install maven.  See https://maven.apache.org/install.html for details.

2. Build the service.

        $ mvn clean package

3. Then execute 

        $ sh run.sh

4. Open http://127.0.0.1:8080/ in a web browser to view your service.


## How Do I generate Api interfaces from swagger specification?

On bash run , 

```bash
java -jar ~/bin/swagger-codegen-cli.jar generate -i api-spec/swagger-carsdemo.yaml -l spring -c  config/swagger-codegen.json
```


## How Do I Add Template Resources to My Project?


To add AWS resources to your project, you'll need to edit the `template.yml`
file in your project's repository. You may also need to modify permissions for
your project's worker roles. After you push the template change, AWS CodeStar
and AWS CloudFormation provision the resources for you.

See the AWS CodeStar user guide for instructions to modify your template:
https://docs.aws.amazon.com/codestar/latest/userguide/how-to-change-project.html#customize-project-template

## What Should I Do Before Running My Project in Production?

AWS recommends you review the security best practices recommended by the framework
author of your selected sample application before running it in production. You
should also regularly review and apply any available patches or associated security
advisories for dependencies used within your application.

Best Practices: https://docs.aws.amazon.com/codestar/latest/userguide/best-practices.html?icmpid=docs_acs_rm_sec

