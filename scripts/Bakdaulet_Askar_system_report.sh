#!/bin/bash

PROJECT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
LOG_FILE="$PROJECT_DIR/logs/Bakdaulet_Askar_system_report.log"

{
    echo "=========================================="
    echo "STUDENT SYSTEM REPORT"
    echo "Student: Bakdaulet Askar"
    echo "Date and time: $(date)"
    echo "Current username: $(whoami)"
    echo "=========================================="

    echo
    echo "OPERATING SYSTEM"
    cat /etc/os-release

    echo
    echo "KERNEL VERSION"
    uname -r

    echo
    echo "CPU INFORMATION"
    lscpu

    echo
    echo "MEMORY INFORMATION"
    free -h

    echo
    echo "DISK USAGE"
    df -h

    echo
    echo "AVAILABLE SPACE ON ROOT FILESYSTEM"
    df -h /

    echo
    echo "REPORT COMPLETED"
} | tee "$LOG_FILE"

