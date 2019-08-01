<template>
    <v-layout align-start justify-end>
        <v-btn-toggle  v-model="toggle_exclusive" >
          <v-btn>
            <v-icon>add</v-icon>
          </v-btn>
          <v-btn>
            <v-icon>add</v-icon>
          </v-btn>
          <v-btn>
            <v-icon>add</v-icon>
          </v-btn>
        </v-btn-toggle>
    </v-layout>
</template>
<script>
export default {
    name: "template",
    props: {
        source: String,
    },
    data: () => ({
        dialog: false,
    }),
}
</script>