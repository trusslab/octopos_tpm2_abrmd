#
# This is the GPIO-DEMO apllication recipe
#
#

SUMMARY = "abrmd autoconf application"
SECTION = "PETALINUX/apps"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
SRC_URI = "file://abrmd \
        "
S = "${WORKDIR}/abrmd"

DEPENDS += " \
    python3 \
    glibc \
    glib-2.0 \
    tss \
    glib-2.0-native \
    pkgconfig-native \
    dbus \
    dbus-native \
    dbus-glib \
    dbus-glib-native \
"

CFLAGS_prepend = "-I ${S}/include"
inherit autotools

FILES_${PN} += "${prefix}/share/dbus-1/*"
FILES_${PN} += "${libdir}/systemd/*"
FILES_${PN}-dev +="${prefix}/share/dbus-1/* ${libdir}/systemd/* ${includedir}"
