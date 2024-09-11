#provider "aws" {
#  region = "us-west-2" # Replace with your desired AWS region
#}
#
#resource "aws_instance" "example" {
#  ami           = "ami-0c55b159cbfafe1f0" # Replace with a suitable AMI ID
#  instance_type = "t2.micro" # Replace with your desired instance type
#  key_name     = "my-key-pair" # Replace with your key pair name
#
#  tags = {
#    Name = "my-ec2-instance"
#  }
#}
#
#resource "aws_security_group" "example" {
#  name        = "my-security-group"
#  description = "Allow SSH and HTTP traffic"
#
#  ingress {
#    from_port   = 22
#    to_port     = 22
#    protocol    = "tcp"
#    cidr_blocks = ["0.0.0.0/0"]
#  }
#
#  ingress  
# {
#    from_port   = 80
#    to_port     = 80
#    protocol    = "tcp"
#    cidr_blocks = ["0.0.0.0/0"]  
#
#  }
#}
#
#resource "aws_instance" "example" {
#  # ... other configuration
#  vpc_security_group_ids = [aws_security_group.example.id]
#}