#!/bin/bash
/mnt/HD/repastworkspace/cenario1/installer/start_model.command &

sleep 10
python3 /home/therocyn/mininet-wifi/examples/s2c2redes/Vinicius/test2_reading_File/simulation.py
