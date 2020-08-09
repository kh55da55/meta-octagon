SUMMARY = "Hardware drivers for TNTFS"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"
require conf/license/license-close.inc

COMPATIBLE_MACHINE = "^(sf8008|sf8008m)$"

KV = "${KERNELVERSION}"
SRCDATE = "20200528"

SRC_URI[md5sum] = "4841409cb7dd8e2104f101d6f70d7aef"
SRC_URI[sha256sum] = "eb64e3870e8db000abe6dcb122428eb424cbdea0db5c3569465a0c0f6a17ee61"

SRC_URI = "http://source.mynonpublic.com/tntfs/${HICHIPSET}-tntfs-${SRCDATE}.zip"

S = "${WORKDIR}"

INHIBIT_PACKAGE_STRIP = "1"

do_compile() {
}

do_populate_sysroot() {
}

do_install() {
    install -d ${D}${base_libdir}/modules/${KV}/extra
    install -d ${D}${sysconfdir}/modules-load.d
    install -m 0755 ${S}/tntfs.ko ${D}${base_libdir}/modules/${KV}/extra
    echo tntfs >> ${D}${sysconfdir}/modules-load.d/tntfs.conf
}

FILES_${PN} += "${sysconfdir}/modules-load.d/tntfs.conf ${base_libdir}/modules/${KV}/extra"
